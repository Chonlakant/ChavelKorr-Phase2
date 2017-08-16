package com.twentyfour.chavel.model;

import java.util.List;

/**
 * Created by Bas on 8/15/2017 AD.
 */

public class HomeFeed {


    /**
     * list : [{"user_id":"2","user_name":"Charoenlap Amatamsombat","user_image":"","route_id":"82","route_title":"testnnn","route_detail":"recvb","diffDate":"345800","like_status":"0","favorite_status":"0","route_activity":"","route_city":"","route_travel_method":"","route_budgetmin":"","route_budgetmax":"","route_suggestion":"","route_img":[]},{"user_id":"2","user_name":"Charoenlap Amatamsombat","user_image":"","route_id":"80","route_title":"test zzz","route_detail":"mcmdm","diffDate":"345930","like_status":"0","favorite_status":"0","route_activity":"","route_city":"","route_travel_method":"","route_budgetmin":"","route_budgetmax":"","route_suggestion":"","route_img":[]},{"user_id":"2","user_name":"Charoenlap Amatamsombat","user_image":"","route_id":"10","route_title":"test pb","route_detail":"pb route","diffDate":"425304","like_status":"0","favorite_status":"0","route_activity":"","route_city":"","route_travel_method":"","route_budgetmin":"","route_budgetmax":"","route_suggestion":"","route_img":[{"img_text":"route_1_1477295529.jpg"}]},{"user_id":"2","user_name":"Charoenlap Amatamsombat","user_image":"","route_id":"7","route_title":"บางขุนเทียน","route_detail":"มีทะเลให้ชม อาหารทะเลอร่อย","diffDate":"425313","like_status":"0","favorite_status":"0","route_activity":"","route_city":"","route_travel_method":"","route_budgetmin":"","route_budgetmax":"","route_suggestion":"","route_img":[{"img_text":"route_1_1477295028.jpg"}]},{"user_id":"2","user_name":"Charoenlap Amatamsombat","user_image":"","route_id":"1","route_title":"Siam Paragon","route_detail":"In Thailand","diffDate":"425413","like_status":"0","favorite_status":"0","route_activity":"","route_city":"","route_travel_method":"","route_budgetmin":"","route_budgetmax":"","route_suggestion":"","route_img":[{"img_text":"route_4_1477289032.jpg"},{"img_text":"route_5_1477289032.jpg"},{"img_text":"route_1_1477289039.jpg"},{"img_text":"route_2_1477289039.jpg"},{"img_text":"route_3_1477289040.jpg"}]}]
     * errors : {"status":"200","source":"/listRoutesFeed","title":"Success","detail":"Get all feed.2"}
     */

    public int type;
    private ErrorsBean errors;
    private List<ListBean> list;

    public ErrorsBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorsBean errors) {
        this.errors = errors;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ErrorsBean {
        /**
         * status : 200
         * source : /listRoutesFeed
         * title : Success
         * detail : Get all feed.2
         */

        private String status;
        private String source;
        private String title;
        private String detail;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class ListBean {
        /**
         * user_id : 2
         * user_name : Charoenlap Amatamsombat
         * user_image :
         * route_id : 82
         * route_title : testnnn
         * route_detail : recvb
         * diffDate : 345800
         * like_status : 0
         * favorite_status : 0
         * route_activity :
         * route_city :
         * route_travel_method :
         * route_budgetmin :
         * route_budgetmax :
         * route_suggestion :
         * route_img : []
         */

        private String user_id;
        private String user_name;
        private String user_image;
        private String route_id;
        private String route_title;
        private String route_detail;
        private String diffDate;
        private String like_status;
        private String favorite_status;
        private String route_activity;
        private String route_city;
        private String route_travel_method;
        private String route_budgetmin;
        private String route_budgetmax;
        private String route_suggestion;
        private List<?> route_img;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_image() {
            return user_image;
        }

        public void setUser_image(String user_image) {
            this.user_image = user_image;
        }

        public String getRoute_id() {
            return route_id;
        }

        public void setRoute_id(String route_id) {
            this.route_id = route_id;
        }

        public String getRoute_title() {
            return route_title;
        }

        public void setRoute_title(String route_title) {
            this.route_title = route_title;
        }

        public String getRoute_detail() {
            return route_detail;
        }

        public void setRoute_detail(String route_detail) {
            this.route_detail = route_detail;
        }

        public String getDiffDate() {
            return diffDate;
        }

        public void setDiffDate(String diffDate) {
            this.diffDate = diffDate;
        }

        public String getLike_status() {
            return like_status;
        }

        public void setLike_status(String like_status) {
            this.like_status = like_status;
        }

        public String getFavorite_status() {
            return favorite_status;
        }

        public void setFavorite_status(String favorite_status) {
            this.favorite_status = favorite_status;
        }

        public String getRoute_activity() {
            return route_activity;
        }

        public void setRoute_activity(String route_activity) {
            this.route_activity = route_activity;
        }

        public String getRoute_city() {
            return route_city;
        }

        public void setRoute_city(String route_city) {
            this.route_city = route_city;
        }

        public String getRoute_travel_method() {
            return route_travel_method;
        }

        public void setRoute_travel_method(String route_travel_method) {
            this.route_travel_method = route_travel_method;
        }

        public String getRoute_budgetmin() {
            return route_budgetmin;
        }

        public void setRoute_budgetmin(String route_budgetmin) {
            this.route_budgetmin = route_budgetmin;
        }

        public String getRoute_budgetmax() {
            return route_budgetmax;
        }

        public void setRoute_budgetmax(String route_budgetmax) {
            this.route_budgetmax = route_budgetmax;
        }

        public String getRoute_suggestion() {
            return route_suggestion;
        }

        public void setRoute_suggestion(String route_suggestion) {
            this.route_suggestion = route_suggestion;
        }

        public List<?> getRoute_img() {
            return route_img;
        }

        public void setRoute_img(List<?> route_img) {
            this.route_img = route_img;
        }

    }
}
