export class Employee {
    public id?: any;
    public name?:string;
    public contractTypeName?: string;
    public roleId?:number;
    public roleName?:string;
    public roleDescription?:string;
    public hourlySalary?:number;
    public monthlySalary?:number;
    public annualSalary?:number;

    constructor(
        id?: any,
        name?:string,
        contractTypeName?: string,
        roleId?: any,
        roleName?:string,
        roleDescription?:string,
        hourlySalary?:number,
        monthlySalary?:number,
        annualSalary?:number
    ) {
        this.id = id ? id : null;
        this.name=name? name:null;
        this.contractTypeName = contractTypeName ? contractTypeName : null;
        this.roleId = roleId ? roleId : null;
        this.roleName=roleName?roleName:null;
        this.roleDescription=roleDescription?roleDescription:null;
        this.hourlySalary=hourlySalary?hourlySalary:null;
        this.monthlySalary=monthlySalary?monthlySalary:null;
        this.annualSalary=annualSalary?annualSalary:null;

    }
}