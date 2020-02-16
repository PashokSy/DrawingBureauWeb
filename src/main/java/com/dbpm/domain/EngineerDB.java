package com.dbpm.domain;

import DBPM_classLibrary.*;
import jdk.nashorn.internal.objects.annotations.Constructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class EngineerDB extends Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Project project;
    private List<Drawing> doneDrawings;
    private List<Drawing> undoneDrawings;
    private List<Drawing> archivedDrawings;
    private String rank;
    private int rankNumber;

    public EngineerDB(String name, String secondName, Department department, Project project) {
        super(name, secondName, department, project);
    }

    public EngineerDB(String name, String secondName, Department department, Project project, int rankNumber) {
        super(name, secondName, department, project, rankNumber);
    }

    protected EngineerDB(String name, String secondName, Department department) {
        super(name, secondName, department);
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
    public List<Drawing> getDoneDrawings() {
        return super.getDoneDrawings();
    }

    @Override
    public void setDoneDrawings(List<Drawing> doneDrawings) {
        super.setDoneDrawings(doneDrawings);
    }

    @Override
    public List<Drawing> getUndoneDrawings() {
        return super.getUndoneDrawings();
    }

    @Override
    public void setUndoneDrawings(List<Drawing> undoneDrawings) {
        super.setUndoneDrawings(undoneDrawings);
    }

    @Override
    public List<Drawing> getArchivedDrawings() {
        return super.getArchivedDrawings();
    }

    @Override
    public void setArchivedDrawings(List<Drawing> archivedDrawings) {
        super.setArchivedDrawings(archivedDrawings);
    }

    @Override
    public List<Drawing> getAllDrawings() {
        return super.getAllDrawings();
    }

    @Override
    public void addDrawing(Drawing drawing) {
        super.addDrawing(drawing);
    }

    @Override
    public void completeDrawing(Drawing drawing) {
        super.completeDrawing(drawing);
    }

    @Override
    public void takeDrawingFromArchive(Drawing drawing) {
        super.takeDrawingFromArchive(drawing);
    }

    @Override
    public String getRank() {
        return super.getRank();
    }

    @Override
    public void setRank(int rankNumber) {
        super.setRank(rankNumber);
    }

    @Override
    public String toString() {
        return super.toString();
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

    public EngineerDB(){super();}
}
