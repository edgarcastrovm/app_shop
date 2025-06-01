const express = require('express');
const router = express.Router();
const productController = require('../controllers/productController');
const { isAuthenticated } = require('../middlewares/auth');

router.get('/', isAuthenticated, productController.listProducts);
router.get('/:id', isAuthenticated, productController.getProductDetails);

module.exports = router;
