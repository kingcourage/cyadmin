$.extend({
    tale: function () {
    }
});


/**
 * 全局post函数
 *
 * @param options   参数
 */
$.tale.prototype.post = function (options) {
    var self = this;
    $.ajax({
        type: 'POST',
        url: options.url,
        data: options.data || {},
        async: options.async || false,
        dataType: 'json',
        success: function (result) {
            options.success && options.success(result);
        },
        error: function () {
            //
        }
    });
};

