package system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RampOA {

    public String[] solution(String[][] queries) {
        int numOfQuery = queries.length;
        String[] res = new String[numOfQuery];

        for (int i = 0; i < numOfQuery; i++) {
            String[] query = queries[i];
            String func = query[0];
            switch (func) {
                case "ADD_FILE" -> {
                    String name = query[1];
                    int size = Integer.parseInt(query[2]);
                    res[i] = addFile(name, size);
                }
                case "GET_FILE_SIZE" -> {
                    String name = query[1];
                    res[i] = getFileSize(name);
                }
                case "DELETE_FILE" -> {
                    String name = query[1];
                    res[i] = deleteFile(name);
                }
                case "GET_N_LARGEST" -> {
                    String prefix = query[1];
                    int n = Integer.parseInt(query[2]);
                    res[i] = getNLargest(prefix, n);
                }
                case "ADD_USER" -> {
                    String userId = query[1];
                    int capacity = Integer.parseInt(query[2]);
                    res[i] = addUser(userId, capacity);
                }
                case "ADD_FILE_BY" -> {
                    String userId = query[1];
                    String name = query[2];
                    int size = Integer.parseInt(query[3]);
                    res[i] = addFileBy(userId, name, size);
                }
                case "MERGE_USER" -> {
                    String userId1 = query[1];
                    String userId2 = query[2];
                    res[i] = mergeUser(userId1, userId2);
                }
            }
        }

        return res;
    }

    Map<String, File> files = new HashMap<>();
    Map<String, User> users = new HashMap<>();

    public String addFile(String name, int size) {
        if (files.containsKey(name)) {
            return "false";
        }

        File file = new File(name, size);
        files.put(name, file);
        return "true";
    }

    public String getFileSize(String name) {
        if (files.containsKey(name)) {
            return String.valueOf(files.get(name).getSize());
        }

        return "";
    }

    public String deleteFile(String name) {
        if (files.containsKey(name)) {
            File file = files.get(name);
            int size = file.getSize();
            if (!file.userId.equals("admin")) {
                User holder = users.get(file.userId);
                holder.capacity += size;
                holder.fileNames.remove(name);
            }
            files.remove(name);
            return String.valueOf(size);
        }

        return "";
    }

    public String getNLargest(String prefix, int n) {
        List<Map.Entry<String, File>> filteredFiles = files.entrySet().stream()
                .filter(e -> e.getKey().startsWith(prefix))
                .sorted((e1, e2) -> {
                    int sizeComp = -Integer.compare(e1.getValue().getSize(),
                            e2.getValue().getSize());
                    if (sizeComp == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return sizeComp;
                })
                .limit(n).toList();

        if (filteredFiles.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, File> file : filteredFiles) {
            sb.append(file.getKey());
            sb.append("(");
            sb.append(file.getValue().getSize());
            sb.append("), ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }

    public String addUser(String userId, int capacity) {
        if (users.containsKey(userId)) {
            return "false";
        }

        User user = new User(userId, capacity);
        users.put(userId, user);
        return "true";
    }

    public String addFileBy(String userId, String name, int size) {
        if (files.containsKey(name)) {
            return "";
        }

        User user = users.get(userId);
        if (user == null) {
            return "";
        }

        // int usedCapacity = user.fileNames.stream()
        //     .filter(files::containsKey)
        //     .mapToInt(fn -> files.get(fn).getSize())
        //     .sum();


        if (user.capacity - size < 0) {
            return "";
        }

        user.fileNames.add(name);
        user.capacity -= size;
        File file = new File(name, size, userId);
        files.put(name, file);
        return String.valueOf(user.capacity);
    }

    public String mergeUser(String userId1, String userId2) {
        if (userId1.equals(userId2)) {
            return "";
        }

        if (!users.containsKey(userId1) || !users.containsKey(userId2)) {
            return "";
        }

        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        user1.capacity += user2.capacity;
        user1.fileNames.addAll(user2.fileNames);

        List<File> user2Files = user2.fileNames.stream()
                .filter(files::containsKey)
                .map(files::get)
                .toList();
        user2Files.forEach(file -> file.setUserId(userId1));

        users.remove(userId2);
        return String.valueOf(user1.capacity);
    }


    public static class File {
        String name;
        int size;
        String userId;

        public File(String name, int size) {
            this.name = name;
            this.size = size;
            this.userId = "admin";
        }

        public File(String name, int size, String userId) {
            this.name = name;
            this.size = size;
            this.userId = userId;
        }

        public String getName() {
            return this.name;
        }

        public int getSize() {
            return this.size;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return this.userId;
        }
    }

    public static class User {
        String userId;
        int capacity;
        List<String> fileNames;

        public User(String userId, int capacity) {
            this.userId = userId;
            this.capacity = capacity;
            fileNames = new ArrayList<>();
        }
    }

}
