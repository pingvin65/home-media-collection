package com.home.media.collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.home.media.collection.models.Episode;
import com.home.media.collection.models.Genre;
import com.home.media.collection.models.Season;
import com.home.media.collection.models.Title;
import com.home.media.collection.models.TitleSeason;
import com.home.media.collection.models.TitleSeasonKey;
import com.home.media.collection.models.Type;
import com.home.media.collection.repositories.EpisodeRepository;
import com.home.media.collection.repositories.GenreRepository;
import com.home.media.collection.repositories.SeasonRepository;
import com.home.media.collection.repositories.TitleRepository;
import com.home.media.collection.repositories.TitleSeasonRepository;
import com.home.media.collection.repositories.TypeRepository;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private TypeRepository typeRepository;

	@Autowired
	private EpisodeRepository episodeRepository;

	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private TitleRepository titleRepository;

	@Autowired
	private TitleSeasonRepository titleSeasonRepository;

	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("--> " + "arguments: {} . ", Arrays.toString(args));
		insertDataInGenreTypeEpisodeSeason();

		insertDataInTitle();

		insertTitleSeasons();
		Optional<TitleSeason> ts = titleSeasonRepository.findById(new TitleSeasonKey(Long.valueOf(1), Long.valueOf(2)));
		logger.info("--> " + "arguments: {} . ", ts.get().getId());

	}

	private void insertTitleSeasons() {
		List<TitleSeason> topCompanies = new ArrayList<>();
		for (long i = 1; i <= 4; i++) {
			for (long j = 1; j <= 10; j++) {
				TitleSeason titleSeason = new TitleSeason(i, j, "picture", "description");
				topCompanies.add(titleSeason);
			}

		}

		logger.info("--> " + "arguments: size  = {} ", topCompanies.size());
		titleSeasonRepository.saveAll(topCompanies);
	}

	/**
	 * 
	 */
	private void insertDataInTitle() {
		List<Title> titles = new ArrayList<>();
		Type typeEntertainment = typeRepository.findByTypeMedia("entertainment").orElseThrow();
		LocalDate date = LocalDate.now().minusMonths(101); 
		HashMap<Integer, Title> titlesTitleHashMap = new HashMap<Integer, Title>();
		for (int i= 1; i<=100; i++) {
			String name = "TV Show " + i; 
			titlesTitleHashMap.put(i, new Title(name, java.sql.Date.valueOf(date.plusMonths(i))));
		}


		for (Entry<Integer, Title> title : titlesTitleHashMap.entrySet())
			titles.add(new Title(title.getValue().getTitle(), "", typeEntertainment, true));
		titleRepository.saveAll(titles);

		try {
			for (Entry<Integer, Title> title : titlesTitleHashMap.entrySet()) {

				Long idTitle = titleRepository.findByTitleIgnoreCase(title.getValue().getTitle()).getIdTitle();
				String exec = String.format("UPDATE `titles` SET `create_date` = '%s' WHERE (`id_title` = '%d')",
						title.getValue().getCreateDate().toString(), idTitle);

				jdbcTemplate.execute(exec);

			}
		} catch (Exception e) {
			logger.error("--> {}", e.getMessage());
		}
		logger.info("--> The title table is filled with the initial data");
	}

	/**
	 * 
	 */
	private void insertDataInGenreTypeEpisodeSeason() {
		List<Genre> genreList = new ArrayList<>();
		List<Type> typeList = new ArrayList<>();
		List<Episode> episodeList = new ArrayList<>();
		List<Season> seasonList = new ArrayList<>();
		String[] typesArray = { "entertainment", "documentary", "game", "document" };
		String[] genreArray = { "Action", "Adventure", "Comedy", "Crime", "Drama", "Fantasy", "Historical",
				"Historical fiction", "Horror", "Magical realism", "Mystery", "Paranoid fiction", "Philosophical",
				"Political", "Romance", "Saga", "Satire", "Science fiction", "Social", "Speculative", "Thriller",
				"Urban", "Western" };

		for (int i = 0; i <= 50; i++) {

			Episode ep = new Episode((long) i);
			episodeList.add(ep);
			if (i > 0 && i <= 10) {
				Season se = new Season((long) i);
				seasonList.add(se);
			}
			if (i < genreArray.length) {
				Genre g = new Genre(genreArray[i], "");
				genreList.add(g);

			}
			if (i < typesArray.length) {
				Type g = new Type(typesArray[i], "");
				typeList.add(g);
			}

		}
		genreRepository.saveAll(genreList);
		typeRepository.saveAll(typeList);
		episodeRepository.saveAll(episodeList);
		seasonRepository.saveAll(seasonList);
		logger.info("--> The genere, type, episode and season tables are populated with the initial data");
	}

}
