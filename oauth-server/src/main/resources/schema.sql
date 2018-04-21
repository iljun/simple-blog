-- Tables for OAuth token store
DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details (
  client_id               VARCHAR(255) PRIMARY KEY,--clientId
  resource_ids            VARCHAR(255),
  client_secret           VARCHAR(255), -- client secret : 클라이언트 비밀번호
  scope                   VARCHAR(255),
  authorized_grant_types  VARCHAR(255), -- client가 로그인하는 정보에 대한 방법
  web_server_redirect_uri VARCHAR(255),
  authorities             VARCHAR(255), -- 클라이언트가 허용되는 역할
  access_token_validity   INTEGER, -- client가 아직 유효한지 판단
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             TINYINT
);

DROP TABLE IF EXISTS oauth_client_token;
CREATE TABLE oauth_client_token (
  token_id          VARCHAR(255),
  token             BLOB,
  authentication_id VARCHAR(255),
  user_name         VARCHAR(255),
  client_id         VARCHAR(255)
);

DROP TABLE IF EXISTS oauth_access_token;
CREATE TABLE oauth_access_token (
  token_id          VARCHAR(255),
  token             BLOB,
  authentication_id VARCHAR(255),
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    BLOB,
  refresh_token     VARCHAR(255)
);

DROP TABLE IF EXISTS oauth_refresh_token;
CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(255),
  token          BLOB,
  authentication BLOB
);

DROP TABLE If EXISTS oauth_code;
CREATE TABLE oauth_code (
  code           VARCHAR(255),
  authentication BLOB
);

INSERT INTO oauth_client_details(
	client_id,
	client_secret,
	resource_ids,
	scope,
	authorized_grant_types,
	web_server_redirect_uri,
	authorities,
	access_token_validity,
	refresh_token_validity,
	additional_information,
	autoapprove
)
VALUES(
	'client1',
	'client1pwd',
	null,
	'read,write',
	'authorization_code,password, implicit, refresh_token',
	null,
	'ROLE_YOUR_CLIENT',
	36000,
	2592000,
	null,
	null
);