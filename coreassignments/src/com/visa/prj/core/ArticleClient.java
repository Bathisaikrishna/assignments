package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.visa.prj.entity.Article;

public class ArticleClient {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
		articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
		articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
		articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
		articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
		
		printTotalWordCount(articles); // 5219
		printArticlesByType(articles); //{bliki:4, article: 1}
		
		// use flatMap, Function.identity and groupingby and Collectors.counting to solve this
		printTagCount(articles); // nosql: 4, ruby : 1, 
	}

	

	private static void printTagCount(List<Article> articles) {
		
		
		Map<String, Long> tagList = articles.stream().flatMap(p -> p.getTags().stream()).collect(Collectors.groupingBy(p -> p, Collectors.counting()));
		
		
		System.out.println(tagList);
	}
		

	private static void printArticlesByType(List<Article> articles) {
		 Map<String, List<Article>> m = articles.stream().collect(Collectors.groupingBy(p->p.getType()));
		 Set<String> keys = m.keySet();
		 for (String key : keys) {
			List<Article> arti = m.get(key);
			
				System.out.println(key + " : " + arti.size());
			
		}
	}

	private static void printTotalWordCount(List<Article> articles) {
		int sum  = 0;
		for (Iterator iterator = articles.iterator(); iterator.hasNext();) {
			Article article = (Article) iterator.next();
			sum += article.getWords();
			
		}
		System.out.println(sum);
	}

}
