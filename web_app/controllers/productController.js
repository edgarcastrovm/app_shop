const javaApi = require('../config/db');

exports.listProducts = async (req, res) => {
  try {
    const response = await javaApi.get('/api/v1/shop/productos', {
      headers: {
        'Authorization': `Bearer ${req.session.token}`
      }
    });
    
    const body = response.data;
    const items = body.data;
    console.log('Respuesta de la API:', response.data);

    res.render('products/list', { productos: items || [] });
  } catch (error) {
    console.error('Error al obtener productos:', error);
    res.status(500).render('error', { message: 'Error al obtener productos' });
  }
};

exports.getProductDetails = async (req, res) => {
  try {
    const { id } = req.params;
    const response = await javaApi.get(`/productos/${id}`, {
      headers: {
        'Authorization': `Bearer ${req.session.token}`
      }
    });
    
    res.render('products/details', { producto: response.data });
  } catch (error) {
    console.error('Error al obtener detalles del producto:', error);
    res.status(500).render('error', { message: 'Error al obtener detalles del producto' });
  }
};