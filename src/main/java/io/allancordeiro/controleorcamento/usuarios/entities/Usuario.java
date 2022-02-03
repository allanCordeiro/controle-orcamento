package io.allancordeiro.controleorcamento.usuarios.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;
    @Column(name="created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name="updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
