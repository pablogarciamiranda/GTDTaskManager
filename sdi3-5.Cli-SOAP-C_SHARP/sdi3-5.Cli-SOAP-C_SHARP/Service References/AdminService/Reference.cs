﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace sdi3_5.Cli_SOAP_C_SHARP.AdminService {
    
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class BusinessException : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string messageField;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://admin.impl.business.sdi.uo/", ConfigurationName="AdminService.AdminService")]
    public interface AdminService {
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        void resetDB();
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task resetDBAsync();
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfoResponse findAllUsersInfo(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfoResponse> findAllUsersInfoAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserByIdResponse findUserById(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserByIdResponse> findUserByIdAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById request);
        
        // CODEGEN: El parámetro 'arg0' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUserResponse disableUser(sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUserResponse> disableUserAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser request);
        
        // CODEGEN: El parámetro 'arg0' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUserResponse enableUser(sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUserResponse> enableUserAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersResponse findAllUsers(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersResponse> findAllUsersAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers request);
        
        // CODEGEN: El parámetro 'arg0' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_5.Cli_SOAP_C_SHARP.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUserResponse deepDeleteUser(sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUserResponse> deepDeleteUserAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser request);
        bool findAllUsers();
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class userInfo : object, System.ComponentModel.INotifyPropertyChanged {
        
        private int completedTasksField;
        
        private string emailField;
        
        private long idField;
        
        private bool idFieldSpecified;
        
        private int lateCompletedTasksField;
        
        private string loginField;
        
        private int plannedTasksField;
        
        private int unplannedTasksField;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public int completedTasks {
            get {
                return this.completedTasksField;
            }
            set {
                this.completedTasksField = value;
                this.RaisePropertyChanged("completedTasks");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string email {
            get {
                return this.emailField;
            }
            set {
                this.emailField = value;
                this.RaisePropertyChanged("email");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public long id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
                this.RaisePropertyChanged("id");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool idSpecified {
            get {
                return this.idFieldSpecified;
            }
            set {
                this.idFieldSpecified = value;
                this.RaisePropertyChanged("idSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public int lateCompletedTasks {
            get {
                return this.lateCompletedTasksField;
            }
            set {
                this.lateCompletedTasksField = value;
                this.RaisePropertyChanged("lateCompletedTasks");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public string login {
            get {
                return this.loginField;
            }
            set {
                this.loginField = value;
                this.RaisePropertyChanged("login");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public int plannedTasks {
            get {
                return this.plannedTasksField;
            }
            set {
                this.plannedTasksField = value;
                this.RaisePropertyChanged("plannedTasks");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=6)]
        public int unplannedTasks {
            get {
                return this.unplannedTasksField;
            }
            set {
                this.unplannedTasksField = value;
                this.RaisePropertyChanged("unplannedTasks");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findAllUsersInfo", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findAllUsersInfo {
        
        public findAllUsersInfo() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findAllUsersInfoResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findAllUsersInfoResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public sdi3_5.Cli_SOAP_C_SHARP.AdminService.userInfo[] @return;
        
        public findAllUsersInfoResponse() {
        }
        
        public findAllUsersInfoResponse(sdi3_5.Cli_SOAP_C_SHARP.AdminService.userInfo[] @return) {
            this.@return = @return;
        }
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class user : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string emailField;
        
        private long idField;
        
        private bool idFieldSpecified;
        
        private bool isAdminField;
        
        private bool isAdminFieldSpecified;
        
        private string loginField;
        
        private string passwordField;
        
        private userStatus statusField;
        
        private bool statusFieldSpecified;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string email {
            get {
                return this.emailField;
            }
            set {
                this.emailField = value;
                this.RaisePropertyChanged("email");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public long id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
                this.RaisePropertyChanged("id");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool idSpecified {
            get {
                return this.idFieldSpecified;
            }
            set {
                this.idFieldSpecified = value;
                this.RaisePropertyChanged("idSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public bool isAdmin {
            get {
                return this.isAdminField;
            }
            set {
                this.isAdminField = value;
                this.RaisePropertyChanged("isAdmin");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool isAdminSpecified {
            get {
                return this.isAdminFieldSpecified;
            }
            set {
                this.isAdminFieldSpecified = value;
                this.RaisePropertyChanged("isAdminSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public string login {
            get {
                return this.loginField;
            }
            set {
                this.loginField = value;
                this.RaisePropertyChanged("login");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public string password {
            get {
                return this.passwordField;
            }
            set {
                this.passwordField = value;
                this.RaisePropertyChanged("password");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public userStatus status {
            get {
                return this.statusField;
            }
            set {
                this.statusField = value;
                this.RaisePropertyChanged("status");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool statusSpecified {
            get {
                return this.statusFieldSpecified;
            }
            set {
                this.statusFieldSpecified = value;
                this.RaisePropertyChanged("statusSpecified");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public enum userStatus {
        
        /// <comentarios/>
        ENABLED,
        
        /// <comentarios/>
        DISABLED,
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findUserById", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findUserById {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public findUserById() {
        }
        
        public findUserById(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findUserByIdResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findUserByIdResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public sdi3_5.Cli_SOAP_C_SHARP.AdminService.user @return;
        
        public findUserByIdResponse() {
        }
        
        public findUserByIdResponse(sdi3_5.Cli_SOAP_C_SHARP.AdminService.user @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="disableUser", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class disableUser {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public disableUser() {
        }
        
        public disableUser(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="disableUserResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class disableUserResponse {
        
        public disableUserResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="enableUser", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class enableUser {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public enableUser() {
        }
        
        public enableUser(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="enableUserResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class enableUserResponse {
        
        public enableUserResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findAllUsers", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findAllUsers {
        
        public findAllUsers() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findAllUsersResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findAllUsersResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public sdi3_5.Cli_SOAP_C_SHARP.AdminService.user[] @return;
        
        public findAllUsersResponse() {
        }
        
        public findAllUsersResponse(sdi3_5.Cli_SOAP_C_SHARP.AdminService.user[] @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="deepDeleteUser", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class deepDeleteUser {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public deepDeleteUser() {
        }
        
        public deepDeleteUser(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="deepDeleteUserResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class deepDeleteUserResponse {
        
        public deepDeleteUserResponse() {
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface AdminServiceChannel : sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class AdminServiceClient : System.ServiceModel.ClientBase<sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService>, sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService {
        
        public AdminServiceClient() {
        }
        
        public AdminServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public AdminServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public AdminServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public AdminServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public void resetDB() {
            base.Channel.resetDB();
        }
        
        public System.Threading.Tasks.Task resetDBAsync() {
            return base.Channel.resetDBAsync();
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfoResponse sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.findAllUsersInfo(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo request) {
            return base.Channel.findAllUsersInfo(request);
        }
        
        public sdi3_5.Cli_SOAP_C_SHARP.AdminService.userInfo[] findAllUsersInfo() {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo();
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfoResponse retVal = ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).findAllUsersInfo(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfoResponse> sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.findAllUsersInfoAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo request) {
            return base.Channel.findAllUsersInfoAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfoResponse> findAllUsersInfoAsync() {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersInfo();
            return ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).findAllUsersInfoAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserByIdResponse sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.findUserById(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById request) {
            return base.Channel.findUserById(request);
        }
        
        public sdi3_5.Cli_SOAP_C_SHARP.AdminService.user findUserById(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById();
            inValue.arg0 = arg0;
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserByIdResponse retVal = ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).findUserById(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserByIdResponse> sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.findUserByIdAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById request) {
            return base.Channel.findUserByIdAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserByIdResponse> findUserByIdAsync(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.findUserById();
            inValue.arg0 = arg0;
            return ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).findUserByIdAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUserResponse sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.disableUser(sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser request) {
            return base.Channel.disableUser(request);
        }
        
        public void disableUser(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser();
            inValue.arg0 = arg0;
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUserResponse retVal = ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).disableUser(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUserResponse> sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.disableUserAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser request) {
            return base.Channel.disableUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUserResponse> disableUserAsync(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.disableUser();
            inValue.arg0 = arg0;
            return ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).disableUserAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUserResponse sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.enableUser(sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser request) {
            return base.Channel.enableUser(request);
        }
        
        public void enableUser(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser();
            inValue.arg0 = arg0;
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUserResponse retVal = ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).enableUser(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUserResponse> sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.enableUserAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser request) {
            return base.Channel.enableUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUserResponse> enableUserAsync(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.enableUser();
            inValue.arg0 = arg0;
            return ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).enableUserAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersResponse sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.findAllUsers(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers request) {
            return base.Channel.findAllUsers(request);
        }
        
        public sdi3_5.Cli_SOAP_C_SHARP.AdminService.user[] findAllUsers() {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers();
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersResponse retVal = ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).findAllUsers(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersResponse> sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.findAllUsersAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers request) {
            return base.Channel.findAllUsersAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsersResponse> findAllUsersAsync() {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.findAllUsers();
            return ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).findAllUsersAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUserResponse sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.deepDeleteUser(sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser request) {
            return base.Channel.deepDeleteUser(request);
        }
        
        public void deepDeleteUser(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser();
            inValue.arg0 = arg0;
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUserResponse retVal = ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).deepDeleteUser(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUserResponse> sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService.deepDeleteUserAsync(sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser request) {
            return base.Channel.deepDeleteUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUserResponse> deepDeleteUserAsync(long arg0) {
            sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser inValue = new sdi3_5.Cli_SOAP_C_SHARP.AdminService.deepDeleteUser();
            inValue.arg0 = arg0;
            return ((sdi3_5.Cli_SOAP_C_SHARP.AdminService.AdminService)(this)).deepDeleteUserAsync(inValue);
        }
    }
}