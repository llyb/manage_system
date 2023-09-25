<template>
    <!-- 引入粒子特效
      <div class="bkpro-login-canvas">
      <Particles
        id="tsparticles"
        :particlesInit="particlesInit"
        :particlesLoaded="particlesLoaded"
        :options="options"
      />
    </div> -->
    <NavBarView />
    <router-view />
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import NavBarView from './views/NavBarView.vue';
import { defineComponent } from 'vue';

export default defineComponent({
    components: {
        NavBarView,
    },
    setup() {
        const options = {
            background: {
                color: {
                    value: '#000', //粒子颜色
                },
            },
            fpsLimit: 60,
            interactivity: {
                events: {
                    onClick: {
                        enable: true,
                        mode: 'push', //可用的click模式有: "push", "remove", "repulse", "bubble"。
                    },
                    onHover: {
                        enable: true,
                        mode: 'grab', //可用的hover模式有: "grab", "repulse", "bubble"。
                    },
                    resize: true,
                },
                modes: {
                    bubble: {
                        distance: 400,
                        duration: 2,
                        opacity: 0.8,
                        size: 40,
                    },
                    push: {
                        quantity: 4,
                    },
                    repulse: {
                        distance: 200,
                        duration: 0.4,
                    },
                },
            },
            particles: {
                color: {
                    value: '#ffffff',
                },
                links: {
                    color: '#ffffff', //'#dedede'。线条颜色。
                    distance: 150, //线条长度
                    enable: true, //是否有线条
                    opacity: 0.5, //线条透明度。
                    width: 1, //线条宽度。
                },
                collisions: {
                    enable: false,
                },
                move: {
                    direction: 'none',
                    enable: true,
                    outMode: 'bounce',
                    random: false,
                    speed: 4, //粒子运动速度。
                    straight: false,
                },
                number: {
                    density: {
                        enable: true,
                        area: 800,
                    },
                    value: 80, //粒子数量。
                },
                opacity: {
                    value: 0.5, //粒子透明度。
                },
                shape: {
                    type: 'circle', //可用的粒子外观类型有："circle","edge","triangle", "polygon","star"
                },
                size: {
                    random: true,
                    value: 5,
                },
            },
            detectRetina: true,
        };
        return {
            options,
        };
    },
});
</script>

<style>
body {
    background-image: url('./assets/01cd34574405ce6ac725550b683178.jpg');
    background-size: cover;
}
</style>
