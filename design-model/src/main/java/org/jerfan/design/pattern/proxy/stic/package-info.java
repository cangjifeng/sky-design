/**
 * 代理模式，静态代理实现<br>
 * <hr>实现方式:<blockquote><pre>
 *    interface Api {
 *
 *       void m()
 *    }
 *
 *    class ApiImpl implements Api {
 *        void m(){
 *            // ...
 *        }
 *    }
 *    class StaticProxyHandler implements Api{
 *        private Api target;
 *
 *        public StaticProxyHandler(Api target){
 *            this.target = target;
 *        }
 *        void m(){
 *            // 增强处理
 *            target.m();
 *            // 增强处理
 *        }
 *    }
 *
 * </pre></blockquote><hr>
 *
 *
 *
 *
 *
 * ------------------------------------------------------------<br>
 * 缺点： <br>
 *     静态代理是硬编码方式实现，得为每个服务创建代理类，工作量大，不易管理。<br>
 *     同时接口一旦变化，代理类也得跟着改动。<br>
 * ------------------------------------------------------------<br>
 * 优点： <br>
 *    在符合开闭原则下，对目标对象进行功能扩展
 */
package org.jerfan.design.pattern.proxy.stic;