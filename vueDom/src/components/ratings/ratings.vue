<template>
  <vue-drawer-layout
    ref="drawerLayout">
    <div class="content" slot="content" ref="viewBox">
      <span @click="go">发表评论</span>
      <div class="section">
        <ul class="list" v-for="(item,index) in comAttr">
          <li >
            <div>
              <div>
                <span id="words">
                  {{item.name}}
                </span>
                <span class="syllable">
                  <star :size="24" :score="item.stars"></star>
                </span>
                <span class="deliveryTime">{{item.times}}分钟送达</span>
              </div>
              <p class="chinese">{{item.comments}}</p>
            </div>
            <div class="btngroud">
              <p class="delbtn">手机号{{item.phone}}</p>
              <button v-on:click="del(item.id)" class="modifybtn">删除</button>
            </div>
          </li>
        </ul>

      </div>
    </div>
  </vue-drawer-layout>
</template>

<script>
  import axios from 'axios'
  import star from 'components/star/star'
  import comment from 'components/ratings/comment'
  import ratings from 'components/ratings/ratings'
  // eslint-disable-next-line no-unused-vars
  export default {
    components: {
      star,
      comment,
      ratings

    },
    inject: ['reload'],
    data () {
      return {
        count: 0,
        page: 1,
        num: null,
        name: '',
        dom: '',
        comAttr: []
      }
    },
    mounted () {
      let _this = this
      // 设置一个开关来避免重负请求数据
      let sw = true
      this.dom = this.$refs.viewBox
      // 注册scroll事件并监听，页面是否滚动到底部
      this.dom.addEventListener('scroll', function () {
        // console.log(document.documentElement.clientHeight + '-&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;' + window.innerHeight); // 可视区域高度
        if (document.body.scrollTop + window.innerHeight >= document.body.offsetHeight) {
          // 如果开关打开则加载数据
          if (sw === true) {
            // 将开关关闭
            sw = false
            _this.page++
            _this.show(_this.page)
          }
        }
      })
    },
    methods: {
      /**
       * 获取数据
       *
       **/
      show: function () {
        let url = 'http://localhost:7000/usermanager/comment/list'
        axios.get(url).then((res) => {
          console.log(res)
          this.comAttr = res.data.page
        }).catch((res) => {
          console.log(res)
          // this.$message({ message: '获取失败', type: 'warning' })
        })
      },
      go: function () {
        this.$router.push({path: '/comment'})
      },
      /**
       * 删除
       *
       **/
      del: function (id) {
        console.log(id)
        let url = 'http://localhost:7000/usermanager/comment/delete?ids=' + id
        axios.get(url).then((res) => {
          alert('删除成功')
          location.reload()
          this.$router.push({path: '/ratings'})
        }).catch((res) => {
          alert('删除失败')
        })
        this.$forceUpdate()
      }
    },
    created () {
      this.show() // 默认显示第一页的内容
    }
  }
</script>

<style scoped>
  .user {
    height: 100px;
    line-height: 100px;
    font-size: 20px;
    font-weight: bold;
  }

  .section {
    margin-top: 55px;
    margin-bottom: 40px;
  }

  .list li {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    background: #ffffff;
    border-radius: 3px;
    margin: 0 10px;
    padding: 12px;
    text-align: left;
    border: 1px #eee solid;
    margin-top: 12px;

  }

  .content {
    height: 100%;
    overflow: auto;
  }

  .list li #words {
    font-size: 16px;
    font-weight: bold;
    margin-right: 8px;
  }

  .list li .syllable {
    margin-right: 16px;
    font-size: 12px;
    color: #666;
  }

  .list li .chinese {
    font-size: 12px;
    color: #666;
  }

  .list li .delbtn {
    width: 72px;
    height: 19px;
    line-height: 16px;
    color: #41b883;
    font-size: 10px;
    text-align: center;
    display: inline-block;
  }

  .list li .modifybtn {
    border-radius: 20px;
    width: 48px;
    height: 19px;
    line-height: 16px;
    color: #ffffff;
    border: 1px #41b883 solid;
    background: #41b883;
    font-size: 10px;
    text-align: center;
    display: inline-block;
  }

  .btn {
    position: fixed;
    left: 10px;
    top: 0;
    top: 12px;
    z-index: 2;
  }

  .btngroud {
    flex: 0 0 100px;
  }

  .drawerList li {
    display: flex;
    align-items: center;
    margin-left: 20px;
    line-height: 45px;
  }

  .drawerList li img {
    margin-right: 10px;
  }

  button {
    background: none;
  }

  .close {
    position: fixed;
    bottom: 10px;
    right: 35%;
    color: #41b883;
    text-decoration: none;
    font-size: 14px;
    align-items: center;
    display: flex;
    font-weight: bold;

  }

  h1, h2 {
    font-weight: normal;
    text-align: center;
  }

  ul li {
    list-style: none;
  }

  .drawer {
    height: 100%;
  }

  .text {
    width: 70%;
    height: 100%;
    background-color: #ffffff;
    box-shadow: 3px 3px 6px 6px #888888;
    font-family: 微软雅黑;
    font-size: 2.1vh;
  }

  .button {

    display: flex;
    flex-direction: row;

    padding-left: 50%;
    padding-top: 2%;
  }

</style>
