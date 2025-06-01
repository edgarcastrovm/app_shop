const javaApi = require('../config/db');

exports.loginForm = (req, res) => {
  res.render('auth/login');
};

exports.login = async (req, res) => {
  try {
    const { username, password } = req.body;
    
    // Llamar a la API Java para autenticación
    const response = await javaApi.post('/api/public/login', {
      email:username,
      password
    });
    const body = response.data;
    const item = body.data;

    console.log('Respuesta de la API:', response.data);

    // Guardar usuario en sesión
    req.session.user = item.usuEmail;
    req.session.token = item.token;
    
    res.redirect('/productos');
  } catch (error) {
    console.error('Error en login:', error);
    res.render('auth/login', { error: 'Credenciales inválidas' });
  }
};



exports.logout = (req, res) => {
  req.session.destroy();
  res.redirect('/');
};