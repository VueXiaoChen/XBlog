import {createRouter, createWebHashHistory,createMemoryHistory,createWebHistory} from 'vue-router';

const router = createRouter({
	// history:createWebHashHistory(),
	history:createWebHistory(),
	routes:[
		{
			path: '/front',
			name: 'Front',
			component: () => import('../views/Front.vue'),
			children: [
			{ path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/front/Home.vue') },
			//{ path: 'home', name: 'FHome', meta: { name: '系统首页' }, component: () => import('../views/front/Home') },
			//   { path: 'person', name: 'Person', meta: { name: '个人信息' }, component: () => import('../views/front/Person') },
			{ path: 'blogDetail', name: 'BlogDetail', meta: { name: '博客详情' }, component: () => import('../views/front/BlogDetail.vue') },
			//   { path: 'search', name: 'Search', meta: { name: '博客搜索' }, component: () => import('../views/front/Search') },
			//   { path: 'activity', name: 'Activity', meta: { name: '活动中心' }, component: () => import('../views/front/Activity') },
			//   { path: 'activityDetail', name: 'ActivityDetail', meta: { name: '活动详情' }, component: () => import('../views/front/ActivityDetail') },
			//   { path: 'newBlog', name: 'NewBlog', meta: { name: '博客编辑' }, component: () => import('../views/front/NewBlog') },
			]
		  },
		  { path: '/login', name: 'Login', meta: { name: '登录' }, component: () => import('../views/Login.vue') },
		  { path: '/', name: '/', meta: { name: '登录' }, component: () => import('../views/Login.vue') },
	]
})

export default router;
