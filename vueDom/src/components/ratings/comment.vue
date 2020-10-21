<template>
  <div class="wrapper">
    <p class="title">发表评论</p>
    <div class="section">
      <ul>
        <li>
          <span>姓名</span>
          <input type="text" v-model="newComment.name" placeholder="请输入你的名字" class="text1"/>
        </li>
        <li>
          <span>电话</span><input type="text" v-model="newComment.phone" placeholder="请输入此你的电话" class="text1"/>

        </li>
        <li>
          <span>评分</span><input type="text" v-model="newComment.stars" placeholder="请输入评分" class="text1"/>

        </li>
        <li>
          <span>送达时间</span><input type="text" v-model="newComment.times" placeholder="请输入送达时间" class="text1"/>

        </li>
        <li>
          <span>评论</span><input type="text" v-model="newComment.comments" placeholder="请输入评论" class="text1"/>

        </li>
      </ul>
    </div>
    <button v-on:click="addComment(newComment)" class="button1">确认添加</button>
  </div>

</template>


<script>
  import axios from 'axios'
  import ratings from 'components/ratings/ratings'

  export default {
    components: {
      ratings
    },
    data() {
      return {
        newComment: {
          name: '',
          phone: '',
          stars: '',
          times: '',
          comments: ''
        }
      }
    },
    methods: {
      addComment: function (newComment) {
        console.log(newComment)
        var url = 'http://localhost:7000/usermanager/comment/save?name=' + newComment.name + '&phone=' + newComment.phone +
          '&stars=' + newComment.stars + '&times=' + newComment.times + '&comments=' + newComment.comments;
        axios.get(url).then((res) => {
          console.log(res)
          if (res.data.code === 555) {
            alert('发生异常,录入失败')
          } else {
            alert('录入成功')
            this.$router.push({path: '/ratings'})
            location.reload()
          }
        }).catch((res) => {
          alert('请求失败')
        })
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    margin-top: 50px;
    text-align: left;
  }

  .title {
    padding-left: 23px;
    margin-bottom: 10px;
    color: #999;
  }

  .section {
    background: #ffffff;
    padding: 0 23px;
  }

  .section li {
    height: 55px;
    line-height: 55px;
    border-bottom: 1px #eee solid;
    font-size: 16px;
  }

  .section input {
    border: none;
    margin-left: 16px;
    font-size: 14px;
  }

  .button1 {
    border: 0;
    background: #41b883;
    border-radius: 3px;
    height: 42px;
    width: calc(100% - 66px);
    margin: 15% 33px 10% 33px;
    font-size: 16px;
    font-weight: bold;

    color: #ffffff;
  }

</style>
