package me.tdd.tddpractice;

public class Study {
    private StudyStatus status;  // = StudyStatus.DRAFT;
    private int limit;
    private String name;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public Study(int limit) {
        if(limit < 0) {
            throw new IllegalArgumentException("Limit must be a positive number");
        }

        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
