package br.com.rifa.email.models;

import br.com.rifa.email.enums.StatusEmail;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collation = "email")
public class EmailModel {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    private String emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
