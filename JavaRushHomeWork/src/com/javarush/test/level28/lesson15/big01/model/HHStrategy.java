package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Andy on 16.07.2016.
 */
public class HHStrategy implements Strategy
{

        private final static String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
        private static final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
        @Override
        public List<Vacancy> getVacancies(String searchString)
        {
                List<Vacancy> vacancies = new ArrayList<>();
                try {
                        int pageNumber = 0;
                        Document doc;
                        while (true) {
                                doc = getDocument(searchString, pageNumber++);
                                if (doc == null) break;

                                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                                if (elements.size() == 0) break;

                                for (Element element : elements) {
                                        // title
                                        Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                                        String title = titleElement.text();

                                        // salary
                                        Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                                        String salary = "";
                                        if (salaryElement != null) {
                                                salary = salaryElement.text();
                                        }

                                        // city
                                        String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                                        // company
                                        String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                                        // site
                                        String siteName = "http://hh.ua/";

                                        // url
                                        String url = titleElement.attr("href");


                                        // add vacancy to the list
                                        Vacancy vacancy = new Vacancy();
                                        vacancy.setTitle(title);
                                        vacancy.setSalary(salary);
                                        vacancy.setCity(city);
                                        vacancy.setCompanyName(companyName);
                                        vacancy.setSiteName(siteName);
                                        vacancy.setUrl(url);
                                        vacancies.add(vacancy);

                                       }

                                }
                }
                catch (Exception e) {
                        //e.printStackTrace();
                }

                return vacancies;


}
        protected Document getDocument(String searchString, int page) throws IOException{
                String url = String.format(URL_FORMAT, searchString, page);
                Document document = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("none")
                        .get();

                return document;
        }

        // public static final String HTTP_HH_UA_SEARCH_VACANCY_TEXT_JAVA_KIEV_PAGE_3 = "http://hh.ua/search/vacancy?text=java+Kiev&page=3";
        //String a = String.format(URL_FORMAT, "Kiev", 3);
       // System.out.println(a);

}

/*
2. Реализуй следующую логику метода getVacancies в классе HHStrategy:
2.1. Приконнекться к закешированной страничке ХэдХантера используя метод getDocument, нумерация начинается с 0.
2.2. Получи список элементов с атрибутом "vacancy-serp__vacancy". Должно быть до 20 вакансий на странице.
2.3. Если данные в списке из п.2.2. есть, то для каждого элемента:
2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
2.4. Выполнить п.2.1-2.3 для следующей страницы ХэдХантера.
2.5. Если закончились страницы с вакансиями, то выйти из цикла.

Исключения игнорировать.
Все вакансии добавить в общий список и вернуть в качестве результата метода.

Подсказка по зарплате:
Поиграйся с URL_FORMAT, добавь туда еще один параметр, чтобы получить вакансии с зарплатами.
Проанализируй полученный html и найди тег для зарплаты.
Не забудь потом вернуть значение URL_FORMAT обратно.
 */