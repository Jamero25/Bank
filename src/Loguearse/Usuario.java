package Loguearse;

import java.sql.Date;

public class Usuario {
		public String id="";
		public String tipo="";
		public String clavenueva="";
		public String mac ="";
		public String claveespecial="";
		public String getClaveespecial() {
			return claveespecial;
		}
		public void setClaveespecial(String claveespecial) {
			this.claveespecial = claveespecial;
		}
		public String getMac() {
			return mac;
		}
		public void setMac(String mac) {
			this.mac = mac;
		}
		public String getClavenueva() {
			return clavenueva;
		}
		public void setClavenueva(String clavenueva) {
			this.clavenueva = clavenueva;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int idcheque;
		public int getIdcheque() {
			return idcheque;
		}
		public void setIdcheque(int idcheque) {
			this.idcheque = idcheque;
		}
		public String descrip="";
		public String getDescrip() {
			return descrip;
		}
		public void setDescrip(String descrip) {
			this.descrip = descrip;
		}
		public String mensaje="";
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		public float montooperacion;
		public float getMontooperacion() {
			return montooperacion;
		}
		public void setMontooperacion(float montooperacion) {
			this.montooperacion = montooperacion;
		}
		public float getSaldodisponible() {
			return saldodisponible;
		}
		public void setSaldodisponible(float saldodisponible) {
			this.saldodisponible = saldodisponible;
		}
		public float saldodisponible;
		public String correo="";
		private String usuario= "";
		private String nombre ="";
		private String clave ="";
		private String tarjeta="";
		private String contra ="";
		private String descripcion="";
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		private String cedula ="";
		private String codigo ="";
		private String cuenta ="";
		private String beneficiario="";
		private float monto;
		public float getMonto() {
			return monto;
		}
		public void setMonto(float monto) {
			this.monto = monto;
		}
		private String servicio= "";
		private String status ="";
		private String	alias = "";
		private String	servicios= "";
		private Date fechasoli=null;
		private Double total;
		private String	contrato= "";
		private String	cedulabene= "";
		private String	benepago= "";
		private String	servipago= "";
		private boolean stats;
		private String fechaDesde="";
		private String fechaHasta="";
		private String fechapago="";
		public String cuentabene="";
		public float montotransfe;
		public float getMontotransfe() {
			return montotransfe;
		}
		public void setMontotransfe(float montotransfe) {
			this.montotransfe = montotransfe;
		}

		public float montoopera;
		
	
		public float getMontoopera() {
			return montoopera;
		}
		public void setMontoopera(float montoopera) {
			this.montoopera = montoopera;
		}
		
		public String getCuentabene() {
			return cuentabene;
		}
		public void setCuentabene(String cuentabene) {
			this.cuentabene = cuentabene;
		}
		public String getBeneficiario() {
			return beneficiario;
		}
		public void setBeneficiario(String beneficiario) {
			this.beneficiario = beneficiario;
		}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getCuenta() {
			return cuenta;
		}
		public void setCuenta(String cuenta) {
			this.cuenta = cuenta;
		}
		
		
		public String getFechapago() {
			return fechapago;
		}
		public void setFechapago(String fechapago) {
			this.fechapago = fechapago;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getContrato() {
			return contrato;
		}
		public void setContrato(String contrato) {
			this.contrato = contrato;
		}
		public String getCedulabene() {
			return cedulabene;
		}
		public void setCedulabene(String cedulabene) {
			this.cedulabene = cedulabene;
		}
		public String getBenepago() {
			return benepago;
		}
		public void setBenepago(String benepago) {
			this.benepago = benepago;
		}
		public String getServipago() {
			return servipago;
		}
		public void setServipago(String servipago) {
			this.servipago = servipago;
		}
	
		
	
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public Date getFechasoli() {
			return fechasoli;
		}
		public void setFechasoli(Date fechasoli) {
			this.fechasoli = fechasoli;
		}
		
		public String getFechaDesde() {
			return fechaDesde;
		}
		public void setFechaDesde(String fechaDesde) {
			this.fechaDesde = fechaDesde;
		}
		public String getFechaHasta() {
			return fechaHasta;
		}
		public void setFechaHasta(String fechaHasta) {
			this.fechaHasta = fechaHasta;
		}

		public String getServicio() {
			return servicio;
		}
		public void setServicio(String servicio) {
			this.servicio = servicio;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getServicios() {
			return servicios;
		}
		public void setServicios(String servicios) {
			this.servicios = servicios;
		}
		public boolean isStats() {
			return stats;
		}
		public void setStats(boolean stats) {
			this.stats = stats;
		}
		
	
	
	
		public String getTarjeta() {
			return tarjeta;
		}
		public void setTarjeta(String tarjeta) {
			this.tarjeta = tarjeta;
		}
		public String getContra() {
			return contra;
		}
		public void setContra(String contra) {
			this.contra = contra;
		}
	
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		

	}


