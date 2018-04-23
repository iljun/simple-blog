export class SavePostDto {
  private title:String;
  private content:String;

  constructor(title:String,content:String){
    this.title = title;
    this.content = content;
  }
}
