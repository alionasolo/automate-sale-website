package automation_practice.scenario_context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScenarioContext {
    private static ScenarioContext instance;
    private Map<ScreenShots, Object> data;

    private ScenarioContext() {
        this.data = new HashMap<>();
    }

    public static ScenarioContext getScenariooContext() {
        if (Objects.isNull(instance)) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public Object getData(ScreenShots key) {
        return data.get(key);
    }

    public void saveData(ScreenShots key, Object object) {
        data.put(key, object);
    }
}


//    private  Map<String, Object> scenarioContext;
//
//    public ScenarioContext(){
//        scenarioContext = new HashMap<>();
//    }
//
//    public void setContext(Context key, Object value) {
//        scenarioContext.put(key.toString(), value);
//    }
//
//    public Object getContext(Context key){
//        return scenarioContext.get(key.toString());
//    }
//
//    public Boolean isContains(Context key){
//        return scenarioContext.containsKey(key.toString());
//    }