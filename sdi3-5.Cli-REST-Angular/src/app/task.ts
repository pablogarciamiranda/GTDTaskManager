export class Task {
    public id: number;

    constructor(public title:string, public comments:string, public created:string, public planned:string, public finished:string, public categoryId:number, public userId:number){
    }
}
