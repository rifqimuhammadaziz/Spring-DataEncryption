package rifqimuhammadaziz.springdataencryption.entity;

import lombok.Data;
import rifqimuhammadaziz.springdataencryption.converter.StringAttributeConverter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Convert(converter = StringAttributeConverter.class)
    @Column(length = 200, unique = true, nullable = false)
    private String cardNumber;

    @Column(length = 100, nullable = false)
    private String expiry;
}
