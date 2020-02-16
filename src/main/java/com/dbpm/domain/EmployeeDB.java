package com.dbpm.domain;

import DBPM_classLibrary.*;

public class EmployeeDB  extends Employee {
    private IdCard idCard;
    private String name;
    private String secondName;
    private Department department;
    private Room room;
    private Project project;

    public EmployeeDB() {
        super();
    }

    public EmployeeDB(String name, String secondName, Department department) {
        super(name, secondName, department);
    }

    public EmployeeDB(String name, String secondName) {
        super(name, secondName);
    }

    @Override
    public IdCard getIdCard() {
        return super.getIdCard();
    }

    @Override
    public void setIdCard(IdCard idCard) {
        super.setIdCard(idCard);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSecondName() {
        return super.getSecondName();
    }

    @Override
    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    @Override
    public Department getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setDepartment(Department department) {
        super.setDepartment(department);
    }

    @Override
    public Room getRoom() {
        return super.getRoom();
    }

    @Override
    public void setRoom(Room room) {
        super.setRoom(room);
    }

    @Override
    public void setRoom(int number) {
        super.setRoom(number);
    }

    @Override
    public Project getProject() {
        return super.getProject();
    }

    @Override
    public void setProject(Project project) {
        super.setProject(project);
    }

    @Override
    public void moveToProject(Project project) {
        super.moveToProject(project);
    }

    @Override
    public boolean isOnProject() {
        return super.isOnProject();
    }

    @Override
    public void moveToRoom(Room room) {
        super.moveToRoom(room);
    }

    @Override
    public void moveToRoom(int number) {
        super.moveToRoom(number);
    }

    @Override
    public void moveToDepartment(Department department) {
        super.moveToDepartment(department);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
