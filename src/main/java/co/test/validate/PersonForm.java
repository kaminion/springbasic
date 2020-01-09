package co.test.validate;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Setter
@Getter
public class PersonForm {

    @NotBlank
    @Size(max=3)
    private String name;

    @Min(0)
    @Max(120)
    private int age;

}
