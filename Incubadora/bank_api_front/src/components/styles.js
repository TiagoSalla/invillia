import { Link } from 'react-router-dom';
import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const RouterLink = styled(Link)`
  color: #fff;

  :hover {
    color: #fff;
    text-decoration: none;
  }
`;

export const NavRouterLink = styled(Link)`
  color: #a9a9a9;

  :hover {
    color: #e9e9e9;
    text-decoration: none;
  }
`;
