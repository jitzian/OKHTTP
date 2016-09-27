
package examples.android.mac.com.org.okhttp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("grade")
    @Expose
    private Double grade;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     * @return
     *     The grade
     */
    public Double getGrade() {
        return grade;
    }

    /**
     * 
     * @param grade
     *     The grade
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }

}
