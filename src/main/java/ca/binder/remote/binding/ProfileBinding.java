package ca.binder.remote.binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ca.binder.domain.Course;
import ca.binder.domain.Profile;

/**
 * @author Mitchell Hentges
 * @since 11/11/2015
 */
public class ProfileBinding implements ModelToJsonBinding<Profile> {
    @Override
    public JSONObject json(Profile object) {
        JSONObject json = new JSONObject();
        try {
            json.put("name", object.getName());
            json.put("bio", object.getBio());
            json.put("program", object.getProgram());
            json.put("phone", object.getPhone());
            json.put("year", object.getYear());
            JSONArray courseArray = new JSONArray();
            for (Course course : object.getCourses()) {
                courseArray.put(course.getName());
            }
            json.put("courses", courseArray);
            json.put("photo", object.getPhoto().base64());
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
