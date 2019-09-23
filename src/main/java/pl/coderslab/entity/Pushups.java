package pl.coderslab.entity;


import javax.persistence.*;

@Entity
@Table
public class Pushups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String day;


    @Column
    private Integer testScore;
    @Column
    private Integer series;
    @Column
    private Integer reps1;
    @Column
    private Integer reps2;
    @Column
    private Integer reps3;
    @Column
    private Integer reps4;
    @Column
    private Integer reps5;
    @Column
    private Integer reps6;
    @Column
    private Integer reps7;
    @Column
    private Integer reps8;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getReps1() {
        return reps1;
    }

    public void setReps1(Integer reps1) {
        this.reps1 = reps1;
    }

    public Integer getReps2() {
        return reps2;
    }

    public void setReps2(Integer reps2) {
        this.reps2 = reps2;
    }

    public Integer getReps3() {
        return reps3;
    }

    public void setReps3(Integer reps3) {
        this.reps3 = reps3;
    }

    public Integer getReps4() {
        return reps4;
    }

    public void setReps4(Integer reps4) {
        this.reps4 = reps4;
    }

    public Integer getReps5() {
        return reps5;
    }

    public void setReps5(Integer reps5) {
        this.reps5 = reps5;
    }

    public Integer getReps6() {
        return reps6;
    }

    public void setReps6(Integer reps6) {
        this.reps6 = reps6;
    }

    public Integer getReps7() {
        return reps7;
    }

    public void setReps7(Integer reps7) {
        this.reps7 = reps7;
    }

    public Integer getReps8() {
        return reps8;
    }

    public void setReps8(Integer reps8) {
        this.reps8 = reps8;
    }
}
