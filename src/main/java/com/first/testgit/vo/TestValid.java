package com.first.testgit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author:jiaxingxu
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestValid {



    @NotBlank(message = "id不能为空")
    private  String  id;

    @NotBlank(message = "name不能为空")
    private  String name;


}
