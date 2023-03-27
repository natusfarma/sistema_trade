const PROXY_CONFIG = [
    {
        context:['/api'],
        target:'localhost:8081',
        secure:false,
        pathRewrite:{'^/api':''}
    }
];

module.exports = PROXY_CONFIG;