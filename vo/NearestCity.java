package vo;

import java.util.*;

/**
 * See: https://leetcode.com/discuss/interview-question/1379696/DoorDASH-Onsite
 */
public class NearestCity {

    public static void main(String[] args) {
        String[] cities = {"a", "aa", "b", "c", "d"};
        int[] positionX = {1, 1, 2, 2, 1};
        int[] positionY = {4, 5, 5, 2, 3};
        String[] queries = {"a", "c", "aa", "e"};
        System.out.println(nearestCity(cities, positionX, positionY, queries));
    }

    public static List<String> nearestCity(String[] cities, int[] positionX, int[] positionY, String[] queries) {
        int n = cities.length;
        Map<String, City> cityMap = new HashMap<>();
        Map<Integer, List<City>> xMap = new HashMap<>(); // x -> city list
        Map<Integer, List<City>> yMap = new HashMap<>(); // y -> city list

        for (int i = 0; i < n; i++) {
            City city = new City(cities[i], positionX[i], positionY[i]);
            cityMap.put(cities[i], city);
            xMap.computeIfAbsent(positionX[i], o -> new ArrayList<>()).add(city);
            yMap.computeIfAbsent(positionY[i], o -> new ArrayList<>()).add(city);
        }

        for (List<City> cityList : xMap.values()) {
            cityList.sort(Comparator.comparingInt(c -> c.y));
        }
        for (List<City> cityList : yMap.values()) {
            cityList.sort(Comparator.comparingInt(c -> c.x));
        }

        List<String> res = new ArrayList<>();
        for (String query : queries) {
            if (!cityMap.containsKey(query)) {
                res.add("None");
                continue;
            }

            City city = cityMap.get(query);
            City xMinCity = getClosestOnAxis(yMap.get(city.y), city, 0);
            City yMinCity = getClosestOnAxis(xMap.get(city.x), city, 1);
            if (xMinCity == null && yMinCity == null) {
                res.add("None");
                continue;
            }

            if (xMinCity == null || yMinCity == null) {
                City exist = (xMinCity == null ? yMinCity : xMinCity);
                res.add(exist.name);
                continue;
            }

            int minDistX = Math.abs(city.x - xMinCity.x);
            int minDistY = Math.abs(city.y - yMinCity.y);

            String name;
            if (minDistX == minDistY) {
                name = xMinCity.name.compareTo(yMinCity.name) < 0 ? xMinCity.name : yMinCity.name;
            } else {
                name = minDistX < minDistY ? xMinCity.name : yMinCity.name;
            }
            res.add(name);
        }

        return res;
    }

    private static City getClosestOnAxis(List<City> lst, City city, int axis) {
        if (lst.size() == 1) {
            return null;
        }

        int index;
        if (axis == 0) {
            index = searchList(lst, city.x, 0);
        } else {
            index = searchList(lst, city.y, 1);
        }

        City leftCity = null, rightCity = null;
        int leftDist = Integer.MAX_VALUE, rightDist = Integer.MAX_VALUE;
        if (index > 0) {
            leftCity = lst.get(index - 1);
            leftDist = axis == 0 ? Math.abs(city.x - leftCity.x) : Math.abs(city.y - leftCity.y);
        }
        if (index < lst.size() - 1) {
            rightCity = lst.get(index + 1);
            rightDist = axis == 0 ? Math.abs(city.x - rightCity.x) : Math.abs(city.y - rightCity.y);
        }

        if (leftDist == rightDist) {
            return leftCity.name.compareTo(rightCity.name) < 0 ? leftCity : rightCity;
        }
        return leftDist < rightDist ? leftCity : rightCity;
    }

    private static int searchList(List<City> lst, int target, int axis) {
        int left = 0, right = lst.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (axis == 0) {
                if (lst.get(mid).x < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (lst.get(mid).y < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return left;
    }


    static class City {
        String name;
        int x;
        int y;

        public City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }
}
