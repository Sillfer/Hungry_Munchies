import {AuthorModel} from './author.model';

export class PostModel {
  constructor(
    public id: number,
    public title: string,
    public content: string,
    public image?: string,
    public ingredients?: string,
    public steps?: string,


    public author?: AuthorModel,

    public created_at?: string,
    public updated_at?: string,
  ) {}
}
