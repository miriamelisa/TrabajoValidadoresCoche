package edu.cesur.fullstack.persistence.entities; //se suelen poner domain o model
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="miri")//nombre de la tabla de pgAdming
public class PersonaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//ESTO SE AUTOINCREMENTA CON ESTA ESTRATEGIA Q ES LA Q SE UTILIZA PARA POSGRETE
	private Integer id;
	
	
	private String name;
	
	
	private String lastName;
	
	
	private int age;
	
	
	private String email;
	
	private String code;


}
