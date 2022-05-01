import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [

  {
    title: 'Relatórios',
    group: true,
  },
  {
    title: 'Ranking Candidados',
    icon: 'file-text-outline',
    link: '/ranking-candidates',
    home: true,
  },
  {
    title: 'GERENCIAR',
    group: true,
  },
  {
    title: 'Candidato',
    icon: 'people-outline',
    link: '/candidate',
  },
  {
    title: 'Categoria',
    icon: 'layers-outline',
    link: '/category',
  },
  {
    title: 'Skill',
    icon: 'flash-outline',
    link: '/skill',
  },
  {
    title: 'Certificado',
    icon: 'award-outline',
    link: '/certified',
  },
];
