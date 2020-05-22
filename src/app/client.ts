import { investor } from './investor';

export class client{
    clientId : number;
    clientName : string;
    clientDescription : string;
    investorList : investor[];

    
    public get invList() : investor[] {
        return this.investorList; 
    }
    
}