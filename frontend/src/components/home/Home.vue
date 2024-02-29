<template>
  <el-container>

    <el-header style="height: 64px">
      <el-row class="block-col-2" justify="end">
        <el-col :span="4">
          <el-dropdown size="large">
        <span class="el-dropdown-link" style="font-size: larger;text-align: right;margin-top: 32px ">
          菠萝偷吃豆腐<el-icon class="el-icon--right"><arrow-down/></el-icon>
        </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item :icon="CirclePlusFilled">我的信息</el-dropdown-item>
                <el-dropdown-item :icon="CircleCheck">登出</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-col>
      </el-row>
    </el-header>

    <el-container style="height: auto">
      <el-aside width="auto">
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">
          <el-radio-button :label="false">expand</el-radio-button>
          <el-radio-button :label="true">collapse</el-radio-button>
        </el-radio-group>
        <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            @open="handleOpen"
            @close="handleClose"
        >
          <el-menu-item index="1">
            <el-icon><Plus /></el-icon>
            <template #title>新建文档</template>
          </el-menu-item>
          <el-menu-item index="2">
            <el-icon>
              <Histogram/>
            </el-icon>
            <template #title>数据总览</template>
          </el-menu-item>
          <el-sub-menu index="3">
            <template #title>
              <el-icon>
                <Document/>
              </el-icon>
              <span>数据汇总</span>
            </template>
            <el-menu-item-group>
              <template #title><span>上海</span></template>
              <el-menu-item index="1-1">回复选登</el-menu-item>
              <el-menu-item index="1-2">领导信箱</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="武汉">
              <el-menu-item index="1-3">城市留言板</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title><span>item four</span></template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="2">
            <el-icon>
              <UserFilled/>
            </el-icon>
            <template #title>用户管理</template>
          </el-menu-item>
          <el-menu-item index="4" disabled>
            <el-icon>
              <document/>
            </el-icon>
            <template #title>管理员操作</template>
          </el-menu-item>
          <el-menu-item index="5">
            <el-icon>
              <setting/>
            </el-icon>
            <template #title>设置</template>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>

  </el-container>

</template>

<script lang="ts" setup>
import {
  ArrowDown,
  Check,
  CircleCheck,
  CirclePlus,
  CirclePlusFilled,
  Plus,
} from '@element-plus/icons-vue'
import {ref} from 'vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

const isCollapse = ref(false)
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.block-col-2 .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}

.block-col-2 .el-dropdown-link {
  display: flex;
  align-items: center;
}
</style>
