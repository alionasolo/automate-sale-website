package automation_practice.configurations;

import automation_practice.data.User;
import cucumber.api.TypeRegistry;
import cucumber.runtime.DefaultTypeRegistryConfiguration;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;


import java.util.Locale;

public class CostumTypeRegistryConfigurer extends DefaultTypeRegistryConfiguration {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }
    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {

        typeRegistry.defineDataTableType(defineOwnDataTable());
    }


    public DataTableType defineOwnDataTable() {

        return new DataTableType(User.class,
                (TableEntryTransformer<User>) dataRow -> {

                    User user = new User();
                    user.setEmailAddress(dataRow.get("Email address"));
                    user.setPassword(dataRow.get("Password"));

                    return user;
                });
    }
//    private DataTableType defineMoviesDescriptions(){
//        return new DataTableType(MovieDescriptionData.class,
//                (TableEntryTransformer<MovieDescriptionData>) dataRow-> {
//                    MovieDescriptionData movieDescriptionData = new MovieDescriptionData();
//                    movieDescriptionData.setInfoTitle(dataRow.get("infoTitle"));
//                    movieDescriptionData.setInfo(dataRow.get("info"));
//                    return  movieDescriptionData;
//                });
   // }
}
