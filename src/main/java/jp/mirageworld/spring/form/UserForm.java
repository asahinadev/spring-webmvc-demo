package jp.mirageworld.spring.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserForm {

	@NotBlank
	@Pattern(regexp = "^[¥\\p{ASCII}]+$")
	@Size(max = 255)
	String username;

	@NotBlank
	@Email
	@Size(max = 255)
	String email;

	@NotBlank
	@Pattern(regexp = "^[¥\\p{ASCII}]+$")
	@Size(max = 255)
	String password;

}
