package com.jk.demo.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jk.demo.Utils.PwdUtils;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordPayload {
  private String username;

  @JsonProperty("new_password")
  private String newPassword;

  @JsonProperty("repeat_new_password")
  private String repeatNewPassword;

  @JsonProperty("old_password")
  private String oldPassword;

  public boolean isValid(String password) {
    return Objects.equals(this.newPassword, this.repeatNewPassword)
        && Objects.equals(PwdUtils.encryption(this.oldPassword), password);
  }
}
