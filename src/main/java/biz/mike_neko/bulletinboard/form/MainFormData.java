package biz.mike_neko.bulletinboard.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MainFormData {
		//private Integer id;
		
		@NotBlank(message="ハンドルネームを入力してください")
		@Size(max=16, message="ハンドルネームは16文字以内にしてください")
		private String handle_name;
		@Size(max=256, message="メールアドレスは256文字以内にしてください")
		private String email;
		@NotBlank(message="投稿内容を記述してください")
		@Size(max=21845, message="一回の投稿は21,845文字以内にしてください")
		private String contents;
}
