import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String FILE_PATH = "data/employees.json";

    public static List<Employee> loadEmployees() {
        try {
            String json = Files.readString(Paths.get(FILE_PATH));
            Type listType = new TypeToken<List<Employee>>(){}.getType();
            return new Gson().fromJson(json, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveEmployees(List<Employee> employees) {
        try {
            String json = new Gson().toJson(employees);
            Files.writeString(Paths.get(FILE_PATH), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}