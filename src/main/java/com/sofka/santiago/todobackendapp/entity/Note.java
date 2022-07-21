package com.sofka.santiago.todobackendapp.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String reminder;
    private String date;
    private Long numberOfTimesModified = 0L;

    public void oneTimeModified(){
        this.numberOfTimesModified ++;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reminder='" + reminder + '\'' +
                ", date='" + date + '\'' +
                ", numberOfTimesModified=" + numberOfTimesModified +
                '}';
    }
}
