/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kecebong.penuliswebapp.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */


@Entity
public class Penulis {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String nama;
    
    @Column @Getter @Setter
    private String judul_buku;

    
    
}
