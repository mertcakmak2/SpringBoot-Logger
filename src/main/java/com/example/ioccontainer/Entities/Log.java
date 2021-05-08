package com.example.ioccontainer.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Log implements IEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logMessage;
}
