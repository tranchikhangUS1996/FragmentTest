package com.tranchikhang.fragmenttest;

/**
 * Created by tranchikhang on 06-Mar-18.
 */

class Workout{
    private String Name;
    private String Description;
    public static Workout[] workouts = {new Workout("The Limb Loosener",
            "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")};

    public Workout(String name, String description) {
        this.Name = name;
        this.Description = description;
    }
    public String getName() {
        return this.Name;
    }
    public String getDescription() {
        return this.Description;
    }
    public String toString() {
        return this.Name;
    }
}
