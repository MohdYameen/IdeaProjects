package com.yameen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UniversityRankingFetcher {
    private static final String API_URL = "https://jsonmock.hackerrank.com/api/universities";

    public static void main(String[] args) {
        try {
            List<University> allUniversities = fetchAllUniversities();

            // Sort universities by ranking
            Collections.sort(allUniversities, Comparator.comparingInt(University::getRank));

            System.out.println("Universities ranked in order:");
            for (University university : allUniversities) {
                if(university.getCountry().equals("India")){
                    System.out.println("Rank " + university.getRank() + ": " + university.getName()+ ", Country : "+university.getCountry());

                }
//                System.out.println("Rank " + university.getRank() + ": " + university.getName()+ ", Country : "+university.getCountry());
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static List<University> fetchAllUniversities() throws Exception {
        List<University> universities = new ArrayList<>();
        int page = 1;
        int totalPages = 1; // Initialize with 1 to enter the loop

        do {
            String urlString = API_URL + "?page=" + page;
//            System.out.println("Fetching page: " + page + " from " + urlString);
            String jsonResponse = getApiResponse(urlString);
            System.out.println(jsonResponse);

            JSONObject jsonObject = new JSONObject(jsonResponse);
            totalPages = jsonObject.getInt("total_pages");
            JSONArray data = jsonObject.getJSONArray("data");


            for (int i = 0; i < data.length(); i++) {
                JSONObject universityJson = data.getJSONObject(i);
                String name = universityJson.getString("university");
                int ranking = universityJson.getInt("rank_display");
                JSONObject locationJson = universityJson.getJSONObject("location");
                String country = locationJson.getString("country");
//                if (locationJson.has("country") && !locationJson.isNull("country")) {
//                    country = locationJson.getString("country");
//                }
                universities.add(new University(name, ranking, country));
            }
            page++;
        } while (page <= totalPages);

        return universities;
    }

    private static String getApiResponse(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // 5 seconds
        connection.setReadTimeout(5000);    // 5 seconds

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Failed to fetch data from " + urlString + ". HTTP error code: " + responseCode);
        }
    }

}

class University{
    String name;
    int rank;

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public University(String name, int rank, String country) {
        this.name = name;
        this.rank = rank;
        this.country = country;
    }

    String country;

}

