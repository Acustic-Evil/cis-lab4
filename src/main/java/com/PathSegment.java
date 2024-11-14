package com;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PathSegment {

    @NotNull(message = "Path ID cannot be null. It is required and should contain only letters, numbers, underscores, or hyphens.")
    @Pattern(
            regexp = "^[A-Za-z0-9_\\-]+$",
            message = "Path ID must contain only letters, numbers, underscores, and hyphens without any spaces or special characters."
    )
    private String pathId;

    @NotNull(message = "Path name cannot be null. Please provide a valid name.")
    @Size(
            min = 3,
            max = 100,
            message = "Path name must be between 3 and 100 characters. Please ensure the name is within this range."
    )
    private String pathName;

    @Min(value = 1, message = "Path length must be a positive number greater than or equal to 1.")
    private int pathLength;

    // Constructor
    public PathSegment(String pathId, String pathName, int pathLength) {
        this.pathId = pathId;
        this.pathName = pathName;
        this.pathLength = pathLength;
    }

    // Getters and Setters
    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }
}

