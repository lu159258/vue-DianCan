<style lang="stylus" rel="stylesheet/stylus">
  @import 'common/stylus/index'
  .tab
    display:flex
    width:100%
    height:40px
    line-height:40px
    border-1px(rgba(7,17,27,0.1))
    .tab-item
      flex:1
      text-align:center
      a
        display:block
        font-size:14px
        color rgb(77,85,93)
        &.active
          font-size 14px
          color rgb(240,20,20)
</style>

<template>
<div>
  <v-header :seller="seller"></v-header>
  <div class="tab">

    <div class="tab-item">
      <router-link to="/goods">商品</router-link>
    </div>
    <div class="tab-item">
      <router-link to="/ratings">评论</router-link>
    </div>
    <div class="tab-item">
      <router-link to="/seller">商家</router-link>
    </div>
    <div class="tab-item">
      <router-link to="/mine">我的</router-link>
    </div>
  </div>
  <keep-alive>
    <router-view :seller="seller"></router-view>
  </keep-alive>

</div>

</template>

<script>
import header from 'components/header/header'
import axios from 'axios'

const ERR_OK = 0

export default {
  provide() { // 注册一个方法
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      seller: {},
      isRouterAlive: true
    }
  },
  created() {
    axios.get('static/data.json').then((res) => {
      this.seller = res.data.seller
    })
  },
  components: {
    'v-header': header
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
}

</script>
